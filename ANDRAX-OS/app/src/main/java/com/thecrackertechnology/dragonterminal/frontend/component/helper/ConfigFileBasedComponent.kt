package com.thecrackertechnology.dragonterminal.frontend.component.helper

import io.neolang.visitor.ConfigVisitor
import com.thecrackertechnology.dragonterminal.component.config.ConfigureComponent
import com.thecrackertechnology.dragonterminal.frontend.component.ComponentManager
import com.thecrackertechnology.dragonterminal.frontend.component.NeoComponent
import com.thecrackertechnology.dragonterminal.frontend.logging.NLog
import java.io.File
import java.io.FileFilter

/**
 * @author kiva
 */
abstract class ConfigFileBasedComponent<out T : ConfigFileBasedObject>(protected val baseDir: String) : NeoComponent {
    companion object {
        private val TAG = ConfigFileBasedComponent::class.java.simpleName

        val NEOLANG_FILTER = FileFilter {
            it.extension == "nl"
        }
    }

    open val checkComponentFileWhenObtained = false

    override fun onServiceInit() {
        val baseDirFile = File(this.baseDir)
        if (!baseDirFile.exists()) {
            if (!baseDirFile.mkdirs()) {
                throw RuntimeException("Cannot create component config directory: ${baseDirFile.absolutePath}")
            }
        }
        onCheckComponentFiles()
    }

    override fun onServiceDestroy() {
    }

    override fun onServiceObtained() {
        if (checkComponentFileWhenObtained) {
            onCheckComponentFiles()
        }
    }

    fun loadConfigure(file: File): T? {
        return try {
            val loaderService = ComponentManager.getComponent<ConfigureComponent>()
            val configure = loaderService.newLoader(file).loadConfigure()
                    ?: throw RuntimeException("Parse configuration failed.")

            val configVisitor = configure.getVisitor()
            val componentObject = onCreateComponentObject(configVisitor)
            componentObject.onConfigLoaded(configVisitor)
            componentObject
        } catch (e: RuntimeException) {
            NLog.e(TAG, "Failed to load config: ${file.absolutePath}: ${e.localizedMessage}")
            null
        }
    }

    abstract fun onCheckComponentFiles()

    abstract fun onCreateComponentObject(configVisitor: ConfigVisitor): T
}