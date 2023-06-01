package com.sr.solorecipe.domain.recipe.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sr.solorecipe.domain.user.domain.entity.User
import com.sr.solorecipe.global.common.entity.BaseIdEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
data class Recipe(
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var thumbnail: String,
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    val user: User,
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "recipe_views")
    val recipeViews: RecipeViews
):BaseIdEntity() {
    fun updateRecipe(name: String, thumbnail: String) {
        this.name = name
        this.thumbnail = thumbnail
    }
}