package com.thecrackertechnology.dragonterminal.frontend.component

/**
 * @author kiva
 */
class ComponentNotFoundException(serviceName: String) : RuntimeException("Component `$serviceName' not found") {
}