package sopt.onsopt.semina.presentation.main.portfolio

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import sopt.onsopt.semina.R
import sopt.onsopt.semina.databinding.FragmentPortfolioBinding
import sopt.onsopt.semina.domain.home.PortfolioDomain
import sopt.onsopt.semina.network.request.GitPortfolioRequest
import sopt.onsopt.semina.network.response.PortfolioDTO
import sopt.onsopt.semina.presentation.main.MainViewModel

class PortfolioFragment() : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()
    private var portfolioAdapter: PortfolioAdapter? = null
    private var portfolioLayoutManager: GridLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPortfolioBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_portfolio, container, false)
        binding.lifecycleOwner = this
        binding.mainViewModel = mainViewModel
        initView(binding)
        return binding.root
    }

    private fun initView(binding: FragmentPortfolioBinding) {
        portfolioAdapter = PortfolioAdapter().apply {
            addOnDetailClickListener { detailClickEvent(it) }
        }
        portfolioLayoutManager = GridLayoutManager(requireContext(), 1)
        binding.portfolioList.apply {
            adapter = portfolioAdapter
            layoutManager = portfolioLayoutManager
        }
    }

    private fun detailClickEvent(url: String) {
        val intent = Intent(requireContext(),InWebActivity::class.java)
            .apply {
                putExtra(InWebActivity.WEB_URL_KEY,url)
            }
        startActivity(intent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadPortfolio()
        observeLayoutTypeEvent()
    }

    private fun loadPortfolio() {
        GitPortfolioRequest().apply {
            setOnSuccessListener { onSuccessLoadPortfolio(it) }
        }.send()
    }

    private fun onSuccessLoadPortfolio(portfolioList: List<PortfolioDTO>) {
        val portfolio: List<PortfolioDomain> = portfolioList.map { it.asDomainModel() }
        portfolioAdapter?.addAllData(portfolio)
    }

    private fun observeLayoutTypeEvent() {
        mainViewModel.layoutType.observe(viewLifecycleOwner) {
            changeLayoutType(it)
        }
    }

    private fun changeLayoutType(layoutType: String) {
        val gridSpan = if (layoutType == MainViewModel.LIST_LAYOUT) 1 else 2
        portfolioLayoutManager?.spanCount = gridSpan
        portfolioAdapter?.notifyItemRangeChanged(0, portfolioAdapter?.itemCount ?: 0)
    }

}