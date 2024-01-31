package org.sostrich.keycloak.pocs;

import static org.hamcrest.core.Is.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class FilterTests {

    /**
     * body set by {@link HelloRequestFilter}
     */
    @Test
    void testContainerResponseFilterWorks() {
        var response = given().get("http://localhost:8080/realms/master/hello/hello").then().extract().response();
        assertThat(response.statusCode(), is(402));

    }

    /**
     * body set by {@link HelloResponseFilter}
     */
    @Test
    void testContainerRequestFilterWorks() {
        var response = given().get("http://localhost:8080/realms/master/hello/hello").then().extract().response();
        assertThat(response.body().print(), is("heeeeeeeeeeeeeeeeello"));
    }
}
