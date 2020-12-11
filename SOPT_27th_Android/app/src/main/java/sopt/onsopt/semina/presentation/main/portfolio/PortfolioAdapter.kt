/*
 * Created By: jinsu4755
 * on 2020.12.10
 */

package sopt.onsopt.semina.presentation.main.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sopt.onsopt.semina.databinding.ItemPortfolioBinding
import sopt.onsopt.semina.domain.home.PortfolioDomain

class PortfolioAdapter : RecyclerView.Adapter<PortfolioAdapter.ViewHolder>() {

    private var onDetailClickListener: ((url:String) -> Unit)? = null

    private val data: MutableList<PortfolioDomain> = mutableListOf()

    fun addOnDetailClickListener(listener: (url:String) -> Unit) {
        this.onDetailClickListener = listener
    }

    fun addAllData(list: List<PortfolioDomain>) {
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemPortfolioBinding
            .inflate(layoutInflater, parent, false)
            .let { ViewHolder(it) }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(
        private val binding: ItemPortfolioBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(customData: PortfolioDomain) {
            binding.portfolio = customData
            itemView.setOnClickListener{clickDetail(customData.html_url)}
        }

        private fun clickDetail(url:String) {
            onDetailClickListener?.invoke(url)
        }

    }
}