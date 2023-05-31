package com.sr.solorecipe.domain.recipe.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class RecipeNotFoundException: BasicException(ErrorCode.RECIPE_NOT_FOUND)