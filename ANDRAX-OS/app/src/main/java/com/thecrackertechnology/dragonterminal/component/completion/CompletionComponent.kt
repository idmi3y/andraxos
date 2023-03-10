package com.thecrackertechnology.dragonterminal.component.completion

import com.thecrackertechnology.dragonterminal.component.completion.provider.FileCompletionProvider
import com.thecrackertechnology.dragonterminal.component.completion.provider.ProgramCompletionProvider
import com.thecrackertechnology.dragonterminal.frontend.completion.CompletionManager
import com.thecrackertechnology.dragonterminal.frontend.component.NeoComponent

/**
 * @author kiva
 */
class CompletionComponent : NeoComponent {
    override fun onServiceInit() {
        CompletionManager.registerProvider(FileCompletionProvider())
        CompletionManager.registerProvider(ProgramCompletionProvider())
    }

    override fun onServiceDestroy() {
    }

    override fun onServiceObtained() {
    }
}