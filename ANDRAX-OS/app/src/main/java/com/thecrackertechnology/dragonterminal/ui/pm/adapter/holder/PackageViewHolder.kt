package com.thecrackertechnology.dragonterminal.ui.pm.adapter.holder

import android.view.View
import android.widget.TextView

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter

import com.thecrackertechnology.andrax.R
import com.thecrackertechnology.dragonterminal.ui.pm.adapter.PackageAdapter
import com.thecrackertechnology.dragonterminal.ui.pm.model.PackageModel

class PackageViewHolder(private val rootView: View, private val listener: PackageAdapter.Listener) : SortedListAdapter.ViewHolder<PackageModel>(rootView) {
    private val packageNameView: TextView = rootView.findViewById(R.id.package_item_name)
    private val packageDescView: TextView = rootView.findViewById(R.id.package_item_desc)

    override fun performBind(item: PackageModel) {
        rootView.setOnClickListener { listener.onModelClicked(item) }
        packageNameView.text = item.packageInfo.packageName
        packageDescView.text = item.packageInfo.description
    }
}
