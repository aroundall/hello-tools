package me.amuji;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JsonCreatorTest {
    @Test
    void json_from_path_and_value() {
        JSONObject team = new JsonCreator().from("team.name", "Star");

        assertThat(team.get("name")).isEqualTo("Star");
    }
}