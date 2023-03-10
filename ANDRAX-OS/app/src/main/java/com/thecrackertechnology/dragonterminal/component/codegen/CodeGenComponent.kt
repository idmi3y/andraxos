package com.thecrackertechnology.dragonterminal.component.codegen

import com.thecrackertechnology.dragonterminal.component.codegen.interfaces.CodeGenObject
import com.thecrackertechnology.dragonterminal.component.codegen.interfaces.CodeGenerator
import com.thecrackertechnology.dragonterminal.frontend.component.NeoComponent

/**
 * @author kiva
 */
class CodeGenComponent : NeoComponent {
    override fun onServiceInit() {
    }

    override fun onServiceDestroy() {
    }

    override fun onServiceObtained() {
    }

    fun newGenerator(codeObject: CodeGenObject): CodeGenerator {
        val parameter = CodeGenParameter()
        return codeObject.getCodeGenerator(parameter)
    }
}

