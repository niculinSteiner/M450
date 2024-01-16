package ch.tbz.recipe.planner.controller;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

public class RecipeControllerTest {

	private MockMvc mockMvc;

	@Mock
	private RecipeService recipeService;

	@InjectMocks
	private RecipeController recipeController;

	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
		this.objectMapper = new ObjectMapper();
	}

	@Test
	public void testGetRecipes() throws Exception {
		List<Recipe> recipes = Collections.singletonList(new Recipe());
		when(recipeService.getRecipes()).thenReturn(recipes);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(recipes)));
	}

	@Test
	public void testGetRecipe() throws Exception {
		UUID recipeId = UUID.randomUUID();
		Recipe recipe = new Recipe();
		when(recipeService.getRecipeById(recipeId)).thenReturn(recipe);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes/recipe/{recipeId}", recipeId))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(recipe)));

	}

	@Test
	public void testAddRecipe() throws Exception {
		Recipe recipe = new Recipe();
		when(recipeService.addRecipe(recipe)).thenReturn(recipe);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/recipes")
						.content(objectMapper.writeValueAsString(recipe))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(recipe)));
	}
}
