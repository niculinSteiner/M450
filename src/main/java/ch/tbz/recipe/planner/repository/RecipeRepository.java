package ch.tbz.recipe.planner.repository;


import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface RecipeRepository extends CrudRepository<RecipeEntity, Long> {
    Optional<RecipeEntity> findById(UUID id);
    List<RecipeEntity> findAll();
    @Modifying
    @Transactional
    @Query("UPDATE RECIPES r SET r.name = :name, r.description = :description, r.imageUrl = :imageUrl WHERE r.id = :id")
    void updateRecipe(@Param("id") UUID id, @Param("name") String name, @Param("description") String description, @Param("imageUrl") String imageUrl);
}
