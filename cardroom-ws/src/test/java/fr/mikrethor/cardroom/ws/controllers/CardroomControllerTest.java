package fr.mikrethor.cardroom.ws.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import fr.mikrethor.cardroom.enums.Domain;
import fr.mikrethor.cardroom.pojo.Account;
import fr.mikrethor.cardroom.ws.config.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class CardroomControllerTest {

	// How to
	// https://spring.io/guides/tutorials/bookmarks/

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	private Account account;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void listAll() throws Exception {
		mockMvc.perform(get("/accounts/")).andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].player.name", is("testnamePlayeWinar")))
				.andExpect(jsonPath("$[0].cardroom.name", is("Winamax")))
				.andExpect(jsonPath("$[0].cardroom.domain", is(Domain.FR.name()))).andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].player.name", is("testnamePlayerPS")))
				.andExpect(jsonPath("$[1].cardroom.name", is("Pokerstars")))
				.andExpect(jsonPath("$[1].cardroom.domain", is(Domain.COM.name())));
	}

	@Test
	public void getHand() throws Exception {

		mockMvc.perform(get("/hands/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.cardRoom.name", is("Winamax")))
				.andExpect(jsonPath("$.cardRoom.domain", is(Domain.FR.name()))).andExpect(jsonPath("$.id", is("1")))
				.andExpect(jsonPath("$.player.name", is("nameplayer")));

	}

}
