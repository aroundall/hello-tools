package me.amuji;

import org.json.JSONObject;
import org.json.XML;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JsonCreatorTest {
    @Test
    void array_can_be_created() {
        JSONObject team = new JsonFlattenerJsonCreator()
                .put("teammates[0].name", "Elisabet")
                .put("teammates[0].age", 32)
                .put("teammates[0].pc.brand", "ThinkPad")
                .put("teammates[0].pc.model", "X12")
                .put("teammates[0].addresses[0].country", "US")
                .put("teammates[0].addresses[0].state", "LA")
                .put("teammates[0].addresses[0].address", "Dummy Addr")
                .put("teammates[0].addresses[0].zipcode", "343-234")
                .put("teammates[0].addresses[1].country", "CN")
                .put("teammates[1].name", "Egídio")
                .put("teammates[1].addresses[0].country", "US")
                .put("teammates[2].name", "Eulalie")
                .create();

        assertThat(team.getJSONArray("teammates").length()).isEqualTo(3);
        assertThat(team.getJSONArray("teammates").getJSONObject(0).get("age")).isEqualTo(32);
        assertThat(team.getJSONArray("teammates").getJSONObject(0).getJSONArray("addresses").length()).isEqualTo(2);
        assertThat(team.getJSONArray("teammates").getJSONObject(2).get("name")).isEqualTo("Eulalie");

        String xml = XML.toString(team);
        assertThat(xml.contains("Egídio")).isTrue();
        assertThat(xml.contains("ThinkPad")).isTrue();
    }
}