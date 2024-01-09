package ch.tbz.recipe.planner.controller;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class RecipeControllerTest {

	@Mock
	private RecipeService recipeService;

	@InjectMocks
	private RecipeController recipeController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testAddRecipe() {
		Recipe recipe = new Recipe();
		doReturn(recipe).when(recipeService).addRecipe(recipe);
		ResponseEntity<Recipe> recipeResponseEntity = recipeController.addRecipe(recipe);
		assertEquals(recipe, recipeResponseEntity.getBody());
	}

	@Test
	public void testGetAllRecipes() {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		Recipe recipe3 = new Recipe();
		List<Recipe> recipes = List.of(recipe1, recipe2, recipe3);

		doReturn(recipes).when(recipeService).getRecipes();
		ResponseEntity<List<Recipe>> recipeResponseEntity = recipeController.getRecipes();
		assertEquals(recipes, recipeResponseEntity.getBody());
	}


	@Test
	public void testGetRecipeByUUID() {
		Recipe recipe = new Recipe();
		doReturn(recipe).when(recipeService).getRecipeById(recipe.getId());
		ResponseEntity<Recipe> recipeResponseEntity = recipeController.getRecipe(recipe.getId());
		assertEquals(recipe, recipeResponseEntity.getBody());
	}

}
