package com.thecrackertechnology.dragonterminal.component.userscript

import android.content.Context
import android.system.Os
import com.thecrackertechnology.andrax.AndraxApp
import com.thecrackertechnology.dragonterminal.frontend.component.NeoComponent
import com.thecrackertechnology.dragonterminal.frontend.config.NeoTermPath
import com.thecrackertechnology.dragonterminal.frontend.logging.NLog
import com.thecrackertechnology.dragonterminal.utils.AssetsUtils
import java.io.File

/**
 * @author kiva
 */
class UserScriptComponent : NeoComponent {
    lateinit var userScripts: MutableList<UserScript>

    override fun onServiceInit() {
        checkForFiles()
    }

    override fun onServiceDestroy() {
    }

    override fun onServiceObtained() {
        checkForFiles()
    }

    private fun extractDefaultScript(context: Context): Boolean {
        try {
            AssetsUtils.extractAssetsDir(context, "scripts", NeoTermPath.USER_SCRIPT_PATH)
            File(NeoTermPath.USER_SCRIPT_PATH)
                    .listFiles().forEach {
                Os.chmod(it.absolutePath, 448 /*Dec of 0700*/)
            }
            return true
        } catch (e: Exception) {
            NLog.e("UserScript", "Failed to extract default user scripts: ${e.localizedMessage}")
            return false
        }
    }

    private fun checkForFiles() {
        File(NeoTermPath.USER_SCRIPT_PATH).mkdirs()
        userScripts = mutableListOf()

        extractDefaultScript(AndraxApp.get())
        reloadScripts()
    }

    fun reloadScripts() {
        val userScriptDir = File(NeoTermPath.USER_SCRIPT_PATH)
        userScriptDir.mkdirs()

        userScripts.clear()
        userScriptDir.listFiles()
                .takeWhile { it.canExecute() }
                .mapTo(userScripts, { UserScript(it) })
    }
}