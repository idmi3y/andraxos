package com.thecrackertechnology.dragonterminal.component.pm

import com.thecrackertechnology.andrax.AndraxApp
import com.thecrackertechnology.andrax.R
import com.thecrackertechnology.dragonterminal.framework.NeoTermDatabase
import com.thecrackertechnology.dragonterminal.frontend.config.NeoTermPath

/**
 * @author kiva
 */
class SourceManager internal constructor() {
    private val database = NeoTermDatabase.instance("sources")

   /** init {
        if (database.findAll<Source>(Source::class.java).isEmpty()) {
            AndraxApp.get().resources.getStringArray(R.array.pref_package_source_values)
                    .forEach {
                        database.saveBean(Source(it, "stable main", true))
                    }
        }
    } */

    fun addSource(sourceUrl: String, repo: String, enabled: Boolean) {
        database.saveBean(Source(sourceUrl, repo, enabled))
    }

    fun removeSource(sourceUrl: String) {
        database.deleteBeanByWhere(Source::class.java, "url == '$sourceUrl'")
    }

    fun updateAll(sources: List<Source>) {
        database.dropAllTable()
        database.saveBeans(sources)
    }

    fun getAllSources(): List<Source> {
        return database.findAll<Source>(Source::class.java)
    }

    fun getEnabledSources(): List<Source> {
        return getAllSources().filter { it.enabled }
    }

    fun getMainPackageSource(): String {
        return getEnabledSources()
                .map { it.repo }
                .singleOrNull { it.trim() == "stable main" }
                ?: NeoTermPath.DEFAULT_MAIN_PACKAGE_SOURCE
    }

    fun applyChanges() {
        database.vacuum()
    }
}
