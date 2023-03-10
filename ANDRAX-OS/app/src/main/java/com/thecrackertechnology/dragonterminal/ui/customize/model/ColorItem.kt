package com.thecrackertechnology.dragonterminal.ui.customize.model

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter
import com.thecrackertechnology.andrax.AndraxApp
import com.thecrackertechnology.andrax.R
import com.thecrackertechnology.dragonterminal.component.colorscheme.NeoColorScheme

/**
 * @author kiva
 */
class ColorItem(var colorType: Int, var colorValue: String) : SortedListAdapter.ViewModel {
    override fun <T> isSameModelAs(t: T): Boolean {
        if (t is ColorItem) {
            return t.colorName == colorName
                    && t.colorValue == colorValue
                    && t.colorType == colorType
        }
        return false
    }

    override fun <T> isContentTheSameAs(t: T): Boolean {
        return isSameModelAs(t)
    }

    var colorName = AndraxApp.get().resources
            .getStringArray(R.array.color_item_names)[colorType - NeoColorScheme.COLOR_TYPE_BEGIN]
}