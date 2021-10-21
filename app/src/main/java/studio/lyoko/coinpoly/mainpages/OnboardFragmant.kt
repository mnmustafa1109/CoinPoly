package studio.lyoko.coinpoly.mainpages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import studio.lyoko.coinpoly.R
import studio.lyoko.coinpoly.databinding.FragmentOnboardBinding


class OnboardFragmant : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        retainInstance = true

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                                              savedInstanceState: Bundle?): View? {

    // Inflate the layout for this fragment
    val binding: FragmentOnboardBinding = DataBindingUtil.inflate(
        inflater,
        R.layout.fragment_onboard, container, false)
        binding.onboardButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_onboardFragmant_to_friendsFragment))
    return binding.root
}
}