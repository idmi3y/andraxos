package com.thecrackertechnology.dragonterminal.frontend.completion.model

import com.thecrackertechnology.dragonterminal.frontend.completion.listener.MarkScoreListener

/**
 * @author kiva
 */
class CompletionResult(val candidates: List<CompletionCandidate>, var scoreMarker: MarkScoreListener) {
    fun markScore(score: Int) {
        scoreMarker.onMarkScore(score)
    }

    fun hasResult(): Boolean {
        return candidates.isNotEmpty()
    }
}