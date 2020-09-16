package org.ara.opa.decision.log;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ResourceTest {

    @Test
    public void testLogWithPartitionNameEndpoint() {
        given()
          .when()
                .body(createOPADecisionLog())
                .contentType("application/json")
                .post("/logs/partition1")
          .then()
             .statusCode(200)
             .body(is(createOPADecisionLog()));
    }

    @Test
    public void testLogEndpoint() {
        given()
                .when()
                .body("{}")
                .contentType("application/json")
                .post("/logs")
                .then()
                .statusCode(200)
                .body(is("{}"));
    }

    private String createOPADecisionLog() {
        return "[\n" +
                "  {\n" +
                "    \"labels\": {\n" +
                "      \"app\": \"my-example-app\",\n" +
                "      \"id\": \"1780d507-aea2-45cc-ae50-fa153c8e4a5a\",\n" +
                "      \"version\": \"v0.13.5\"\n" +
                "    },\n" +
                "    \"decision_id\": \"4ca636c1-55e4-417a-b1d8-4aceb67960d1\",\n" +
                "    \"bundles\": {\n" +
                "      \"authz\": {\n" +
                "        \"revision\": \"W3sibCI6InN5cy9jYXRhbG9nIiwicyI6NDA3MX1d\"\n" +
                "      }    \n" +
                "    }, \n" +
                "    \"path\": \"http/example/authz/allow\",\n" +
                "    \"input\": {\n" +
                "      \"method\": \"GET\",\n" +
                "      \"path\": \"/salary/bob\"\n" +
                "    },\n" +
                "    \"result\": \"true\",\n" +
                "    \"requested_by\": \"[::1]:59943\",\n" +
                "    \"timestamp\": \"2018-01-01T00:00:00.000000Z\"\n" +
                "  }\n" +
                "]";
    }
    /*https://www.openpolicyagent.org/docs/v0.13.5/decision-logs/*/
}