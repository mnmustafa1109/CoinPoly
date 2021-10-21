package studio.lyoko.coinpoly.sucesspage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import studio.lyoko.coinpoly.R
import studio.lyoko.coinpoly.dashboardpage.DashboardFragment
import studio.lyoko.coinpoly.databinding.FragmentDashboardBinding
import studio.lyoko.coinpoly.databinding.FragmentSucessBinding


class SucessFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSucessBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sucess, container, false)
        binding.playagainButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_sucessFragment_to_onboardFragmant))
        val args = SucessFragmentArgs.fromBundle(requireArguments())
        binding.winnerText.text= "The winner is ${args.winner}"

        return binding.root
    }

}