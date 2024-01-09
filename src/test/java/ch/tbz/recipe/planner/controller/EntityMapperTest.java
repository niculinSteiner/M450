package ch.tbz.recipe.planner.controller;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import ch.tbz.recipe.planner.mapper.IngredientEntityMapper;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

public class EntityMapperTest {

	RecipeEntityMapper recipeEntityMapper = Mappers.getMapper(RecipeEntityMapper.class);
	IngredientEntityMapper ingredientEntityMapper = Mappers.getMapper(IngredientEntityMapper.class);

	@Test
	public void testRecipeMapperEntityToDomain() {
		RecipeEntity recipeEntity = new RecipeEntity();
		recipeEntity.setId(UUID.randomUUID());
		recipeEntity.setName("test");

		Recipe recipe = recipeEntityMapper.entityToDomain(recipeEntity);

		SoftAssertions softAssertion = new SoftAssertions();
		softAssertion.assertThat(recipeEntity.getId()).isEqualTo(recipe.getId());
		softAssertion.assertThat(recipeEntity.getName()).isEqualTo(recipe.getName());
		softAssertion.assertAll();
	}

	@Test
	public void testRecipeMapperDomainToEntity() {
		Recipe recipe = new Recipe();
		recipe.setId(UUID.randomUUID());
		recipe.setName("test");

		RecipeEntity recipeEntity = recipeEntityMapper.domainToEntity(recipe);

		SoftAssertions softAssertion = new SoftAssertions();
		softAssertion.assertThat(recipe.getId()).isEqualTo(recipeEntity.getId());
		softAssertion.assertThat(recipe.getName()).isEqualTo(recipeEntity.getName());
		softAssertion.assertAll();
	}

	@Test
	public void testIngredientMapperDomainToEntity() {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(UUID.randomUUID());
		ingredient.setName("test");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setId(UUID.randomUUID());
		ingredient2.setName("test2");
		Ingredient ingredient3 = new Ingredient();
		ingredient3.setId(UUID.randomUUID());
		ingredient3.setName("test3");

		List<Ingredient> ingredients = List.of(ingredient, ingredient2, ingredient3);

		IngredientEntity ingredientEntity = ingredientEntityMapper.domainToEntity(ingredient);
		List<IngredientEntity> ingredientEntities = ingredientEntityMapper.domainsToEntities(ingredients);

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(ingredientEntity.getId()).isEqualTo(ingredient.getId());
		softAssertions.assertThat(ingredientEntity.getName()).isEqualTo(ingredient.getName());
		softAssertions.assertThat(ingredientEntities.get(2).getName()).isEqualTo(ingredients.get(2).getName());
		softAssertions.assertAll();
	}

	@Test
	public void testIngredientMapperEntityToDomain() {
		IngredientEntity ingredientEntity = new IngredientEntity();
		ingredientEntity.setId(UUID.randomUUID());
		ingredientEntity.setName("test");
		IngredientEntity ingredientEntity2 = new IngredientEntity();
		ingredientEntity2.setId(UUID.randomUUID());
		ingredientEntity2.setName("test2");
		IngredientEntity ingredientEntity3 = new IngredientEntity();
		ingredientEntity3.setId(UUID.randomUUID());
		ingredientEntity3.setName("test3");

		List<IngredientEntity> ingredientEntities = List.of(ingredientEntity, ingredientEntity2, ingredientEntity3);

		Ingredient ingredient = ingredientEntityMapper.entityToDomain(ingredientEntity);
		List<Ingredient> ingredients = ingredientEntityMapper.entitiesToDomains(ingredientEntities);

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(ingredientEntity.getId()).isEqualTo(ingredient.getId());
		softAssertions.assertThat(ingredientEntity.getName()).isEqualTo(ingredient.getName());
		softAssertions.assertThat(ingredientEntities.get(2).getName()).isEqualTo(ingredients.get(2).getName());
		softAssertions.assertAll();
	}


}
