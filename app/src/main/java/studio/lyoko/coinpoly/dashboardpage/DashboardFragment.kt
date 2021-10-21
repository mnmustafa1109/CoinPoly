package studio.lyoko.coinpoly.dashboardpage

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.exiting_dialog.view.*
import studio.lyoko.coinpoly.R
import studio.lyoko.coinpoly.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        requireActivity().onBackPressedDispatcher.addCallback(this) {

            showMessageBox()

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentDashboardBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dashboard, container, false)

        binding.endButton.setOnClickListener {
            showMessageBox()
        }

            return binding.root
    }

    private fun showMessageBox(){

        //Inflate the dialog as custom view
        val messageBoxView = LayoutInflater.from(activity).inflate(R.layout.exiting_dialog, null)

        //AlertDialogBuilder
        val messageBoxBuilder = activity?.let { AlertDialog.Builder(it).setView(messageBoxView) }



        //show dialog
        val  messageBoxInstance: AlertDialog?
        messageBoxInstance = messageBoxBuilder?.show()



        if (messageBoxInstance != null) {
            messageBoxInstance.getWindow()?.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
        }

        //setting text values
        messageBoxView.sure_button.setOnClickListener{
            messageBoxInstance?.dismiss()
            view?.findNavController()
            ?.navigate(DashboardFragmentDirections.actionDashboardFragmentToSucessFragment("Mustaf"))}


        messageBoxView.nope_button.setOnClickListener {
            messageBoxInstance?.dismiss()
        }
    }
}