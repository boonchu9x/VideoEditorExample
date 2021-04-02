/*
 *
 *  Created by Optisol on Aug 2019.
 *  Copyright © 2019 Optisol Business Solutions pvt ltd. All rights reserved.
 *
 */

package com.obs.marveleditor.adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.obs.marveleditor.R
import com.obs.marveleditor.model.FrameEntity
import kotlin.properties.Delegates

class VideoPreviewAdapter(private val height: Int, val context: Context) :
    RecyclerView.Adapter<VideoPreviewAdapter.ViewHolder>() {

    private var mData: List<Bitmap> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }
    private val mInflater: LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_layout_video_thumb, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.updateView(mData[position],height)
    }

    fun submitList(list: List<Bitmap>?) {
        if (list != null) {
            mData = list
        }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgThumbnail: ImageView = itemView.findViewById(R.id.thumb_item_tile_view)

        fun updateView(bitmap: Bitmap, height: Int) {
            imgThumbnail.setImageBitmap(bitmap)
            val layoutParams = imgThumbnail.layoutParams
            layoutParams.width = height
            imgThumbnail.layoutParams = layoutParams
        }
    }
}