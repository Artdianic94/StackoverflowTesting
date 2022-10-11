package API.restassured_tests;

import API.Client;
import API.models.Item;
import API.models.Items;
import API.models.Owner;
import API.models.QueryModel;
import API.static_data.Endpoints;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class LastTenAnswersTest {

    @Test
    public void getLastTenAnswersTest() {
        Client client = new Client();

        QueryModel queryModel = new QueryModel();
        Map<String, String> queryParam = queryModel.getQueryParamsForLastTenAnswers();
        String answersEndpoint = Endpoints.ANSWERS;

        Response response = client.getRequestSpec(queryParam, answersEndpoint);
        response.then().statusCode(HttpStatus.SC_OK);

        List<Item> itemsList = List.of(response.as(Items.class).getItems());
        int actualItemsListSize = itemsList.size();
        int expectedItemsListSize = 10;
        Assertions.assertThat(actualItemsListSize).isLessThanOrEqualTo(expectedItemsListSize);

        for (Item item : itemsList) {
            String actualLink = item.getOwner().getLink();
            String userId = String.valueOf(item.getOwner().getUser_id());
            String displayName = item.getOwner().getDisplay_name()
                    .toLowerCase().replace(" ", "-").replace(".", "");
            String expectedLink = "https://stackoverflow.com/users/"
                    + userId + "/" + displayName;
            Assert.assertEquals(actualLink, expectedLink, "Links don't match");

            Assertions.assertThat(item.getOwner().getClass()).isAssignableFrom(Owner.class);
        }
    }
}
