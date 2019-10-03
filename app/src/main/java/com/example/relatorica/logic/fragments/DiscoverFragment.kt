package com.example.relatorica.logic.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import com.example.relatorica.R
import com.example.relatorica.logic.adapters.ParentsAdapter
import com.example.relatorica.logic.models.ParentModel
import com.example.relatorica.logic.network.RestClient
import kotlinx.android.synthetic.main.fragment_discover.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class DiscoverFragment : Fragment() {

    private lateinit var parentsAdapter: ParentsAdapter
    val auth: String = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IkFkbWluIiwibmJmIjoxNTcwMTE3NTY4LCJleHAiOjE1NzAxMjQ3NjgsImlhdCI6MTU3MDExNzU2OCwiaXNzIjoiaHR0cDovLzE4LjE4OC4xMDIuMjMwL1JlbGF0b3JpY2EvIiwiYXVkIjoiaHR0cDovLzE4LjE4OC4xMDIuMjMwL1JlbGF0b3JpY2EvIn0.f_qtMv2Fy-ILx1gOzCHCwUexoX4Vh97vg7-O6TMzWsE"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_discover, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentsAdapter = ParentsAdapter(fragment = this)
        parentsRecyclerView.apply {
            adapter = parentsAdapter
            layoutManager = GridLayoutManager(view.context, 1)
        }
        updateParents()
    }

    override fun onResume() {
        super.onResume()
        updateParents()
    }

    private fun updateParents() {
        val call = RestClient().service.getParents(auth)
        call.enqueue(object : Callback<ParentModel.Response> {
            override fun onResponse(call: Call<ParentModel.Response>, response: Response<ParentModel.Response>) {
                print(response)
                val parents = response.body()!!.data
                print(parents)
                parentsAdapter.parents = parents
                parentsAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ParentModel.Response>, t: Throwable) {
                Log.d("FAILURE", t.toString())
            }
        })

    }


}
