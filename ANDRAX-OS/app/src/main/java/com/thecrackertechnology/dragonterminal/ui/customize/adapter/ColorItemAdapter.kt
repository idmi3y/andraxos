package com.thecrackertechnology.dragonterminal.ui.customize.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
import com.thecrackertechnology.andrax.R
import com.thecrackertechnology.dragonterminal.component.colorscheme.NeoColorScheme
import com.thecrackertechnology.dragonterminal.ui.customize.adapter.holder.ColorItemViewHolder
import com.thecrackertechnology.dragonterminal.ui.customize.model.ColorItem
import java.util.*

/**
 * @author kiva
 */
class ColorItemAdapter(context: Context, initColorScheme: NeoColorScheme, comparator: Comparator<ColorItem>, private val listener: ColorItemAdapter.Listener)
    : SortedListAdapter<ColorItem>(context, ColorItem::class.java, comparator), FastScrollRecyclerView.SectionedAdapter {

    val colorList = mutableListOf<ColorItem>()

    init {
        (NeoColorScheme.COLOR_TYPE_BEGIN..NeoColorScheme.COLOR_TYPE_END)
                .forEach {
                    colorList.add(ColorItem(it, initColorScheme.getColor(it) ?: ""))
                }
        edit().add(colorList).commit()
    }

    interface Listener {
        fun onModelClicked(model: ColorItem)
    }

    override fun getSectionName(position: Int): String {
        return colorList[position].colorName[0].toString()
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): SortedListAdapter.ViewHolder<out ColorItem> {
        val rootView = inflater.inflate(R.layout.item_color, parent, false)
        return ColorItemViewHolder(rootView, listener)
    }
}
