package com.thecrackertechnology.dragonterminal.component.codegen.interfaces

import com.thecrackertechnology.dragonterminal.component.codegen.CodeGenParameter

/**
 * @author kiva
 */
interface CodeGenObject {
    fun getCodeGenerator(parameter: CodeGenParameter): CodeGenerator
}