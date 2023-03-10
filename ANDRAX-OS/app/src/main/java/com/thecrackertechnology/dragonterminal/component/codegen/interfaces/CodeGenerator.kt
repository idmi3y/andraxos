package com.thecrackertechnology.dragonterminal.component.codegen.interfaces

import com.thecrackertechnology.dragonterminal.component.codegen.CodeGenParameter

/**
 * @author kiva
 */
abstract class CodeGenerator(parameter: CodeGenParameter) {
    abstract fun getGeneratorName(): String

    abstract fun generateCode(codeGenObject: CodeGenObject): String
}
