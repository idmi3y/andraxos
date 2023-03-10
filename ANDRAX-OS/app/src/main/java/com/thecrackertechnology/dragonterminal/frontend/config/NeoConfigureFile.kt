package com.thecrackertechnology.dragonterminal.frontend.config

import io.neolang.parser.NeoLangParser
import io.neolang.visitor.ConfigVisitor
import com.thecrackertechnology.dragonterminal.frontend.logging.NLog
import com.thecrackertechnology.dragonterminal.utils.FileUtils
import java.io.File

/**
 * @author kiva
 */
open class NeoConfigureFile(val configureFile: File) {
    private val configParser = NeoLangParser()
    open protected var configVisitor : ConfigVisitor? = null

    fun getVisitor(): ConfigVisitor {
        checkParsed()
        return configVisitor!!
    }

    open fun parseConfigure(): Boolean {
        val configContent = FileUtils.readFile(configureFile)
        if (configContent == null) {
            NLog.e("ConfigureFile", "Cannot read file $configureFile")
            return false
        }
        val programCode = String(configContent)
        configParser.setInputSource(programCode)

        val ast = configParser.parse()
        val astVisitor = ast.visit().getVisitor(ConfigVisitor::class.java) ?: return false
        astVisitor.start()
        configVisitor = astVisitor.getCallback()
        return true
    }

    private fun checkParsed() {
        if (configVisitor == null) {
            throw IllegalStateException("Configure file not loaded or parse failed.")
        }
    }
}
