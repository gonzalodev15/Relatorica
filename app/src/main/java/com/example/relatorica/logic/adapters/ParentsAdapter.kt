package com.example.relatorica.logic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.relatorica.R
import com.example.relatorica.logic.models.ParentModel
import kotlinx.android.synthetic.main.item_parent.view.*

class ParentsAdapter(var parents: ArrayList<ParentModel.Parent> = ArrayList(), val fragment: Fragment)
    : RecyclerView.Adapter<ParentsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_parent, parent, false))
    }

    override fun getItemCount(): Int = parents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row = parents[position]

        holder.namesTextView.text = row.names
        holder.emailTextView.text = row.email
        holder.cellphoneTextView.text = row.cellphone

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var namesTextView: TextView = itemView.findViewById<View>(R.id.parentNameTextView) as TextView
        var emailTextView: TextView = itemView.findViewById<View>(R.id.parentEmailTextView) as TextView
        var cellphoneTextView: TextView = itemView.findViewById(R.id.parentCellphoneTextView) as TextView
    }
}