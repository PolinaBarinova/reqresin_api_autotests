package reqres.tests;

import io.qameta.allure.Owner;
import reqres.models.CreateAndUpdateUserBodyModel;
import reqres.models.CreateResponseModel;
import reqres.models.ListUsersResponseModel;
import reqres.models.UpdateResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static reqres.specs.ReqresInSpecs.*;

@Tag("reqresin")
@DisplayName("REST API тесты")
@Owner("p.barinova")
public class ReqresInRestApiTestsWithModels extends TestBase {

    int existingUserId = 2;
    int nonExistingUserId = 23;

    @DisplayName("Получить список пользователей")
    @Test
    void getListUsersTest() {
        ListUsersResponseModel response = step("Получить список пользователей", () ->
                given(requestSpec)

                        .when()
                        .queryParam("page", 2)
                        .get(endpoint_users)

                        .then()
                        .spec(responseWithStatusCode200Spec)
                        .extract().as(ListUsersResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals(2, response.getPage());
            assertFalse(response.getData().isEmpty(), "Список пользователей не должен быть пустым");
        });
    }

    @DisplayName("Создать пользователя")
    @Test
    public void createUserTest() {

        CreateAndUpdateUserBodyModel requestBody = new CreateAndUpdateUserBodyModel();
        requestBody.setName("morpheus");
        requestBody.setJob("leader");

        CreateResponseModel response = step("Отправить запрос", () ->
                given(requestSpec)
                        .body(requestBody)

                        .when()
                        .post(endpoint_users)

                        .then()
                        .spec(responseCreateUserSpec)
                        .extract().as(CreateResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals("morpheus", response.getName(), "Name не совпадает");
            assertEquals("leader", response.getJob(), "Job не совпадает");
        });
    }

    @DisplayName("Полностью обновить информацию о пользователе (PUT)")
    @Test
    public void updateUserTest() {

        CreateAndUpdateUserBodyModel requestBody = new CreateAndUpdateUserBodyModel();
        requestBody.setName("morpheus");
        requestBody.setJob("zion resident");

        UpdateResponseModel response = step("Отправить запрос", () ->
                given(requestSpec)
                        .body(requestBody)

                        .when()
                        .put(endpoint_users + existingUserId)

                        .then()
                        .spec(responseWithStatusCode200Spec)
                        .extract().as(UpdateResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals("morpheus", response.getName(), "Name не совпадает");
            assertEquals("zion resident", response.getJob(), "Job не совпадает");
        });
    }

    @DisplayName("Заменить чаcть информации o пользователе (PATCH)")
    @Test
    public void replaceDataUserTest() {
        CreateAndUpdateUserBodyModel requestBody = new CreateAndUpdateUserBodyModel();
        requestBody.setName("morpheus");
        requestBody.setJob("zion resident");

        UpdateResponseModel response = step("Отправить запрос", () ->
                given(requestSpec)
                        .body(requestBody)

                        .when()
                        .patch(endpoint_users + existingUserId)

                        .then()
                        .spec(responseWithStatusCode200Spec)
                        .extract().as(UpdateResponseModel.class));

        step("Проверить ответ", () -> {
            assertEquals("morpheus", response.getName(), "Name не совпадает");
            assertEquals("zion resident", response.getJob(), "Job не совпадает");
        });
    }

    @DisplayName("Ошибка при попытке получить несуществующего пользователя")
    @Test
    public void getUserNotFoundTest() {
        step("Отправить запрос на получение пользователя по id", () ->
                given(requestSpec)

                        .when()
                        .get(endpoint_users + nonExistingUserId)

                        .then()
                        .spec(responseGetUserNotFoundSpec));
    }

    @DisplayName("Удалить пользователя")
    @Test
    public void deleteUserTest() {
        step("Удалить пользователя", () ->
                given(requestSpec)

                        .when()
                        .delete(endpoint_users + existingUserId)

                        .then()
                        .spec(responseDeleteUserSpec));
    }
}
