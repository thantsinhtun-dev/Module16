package com.stone.module16.fragments

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.stone.module16.R
import com.stone.module16.adapters.SheetProfileAdapter
import com.stone.module16.data.ProfileVO
import com.stone.module16.mvp.presenter.MainPresenterImpl
import com.stone.module16.mvp.presenter.ProfilePresenter
import com.stone.module16.mvp.presenter.ProfilePresenterImpl
import com.stone.module16.mvp.view.ProfileView
import com.stone.module16.utils.profileList
import com.stone.module16.utils.taskData
import kotlinx.android.synthetic.main.fragment_profie.*
import kotlinx.android.synthetic.main.fragment_profie.view.*


class ProfileFragment(val profileId: Int) : BottomSheetDialogFragment(), ProfileView {

    private val tabList = listOf("Project Tasks", "Contacts", "About You")
    lateinit var profilePresenter: ProfilePresenter

    private var selectedImage: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profie, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)

       selectedImage = profileList.filter { it.id==profileId }.first().profileImage

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.imgClose.setOnClickListener {
            profilePresenter.onTapClose()
        }

        setUpPresenter()
        setupTabLayout()
        setUpRecyclerView()
        profilePresenter.onUIReady(this)

        view.circularImageView.setImageResource(selectedImage)
    }

    private fun setUpPresenter() {
        profilePresenter = ViewModelProvider(this)[ProfilePresenterImpl::class.java]
        profilePresenter.initializeView(this)
    }

    private fun setUpRecyclerView() {
        val adapter = SheetProfileAdapter()
        rvProfileSheet.adapter = adapter
        taskData.forEach {
            it.profile = selectedImage
        }

        adapter.setNewData(taskData)
    }

    private fun setupTabLayout() {
        tabList.forEach {
            tabLayoutProfile.newTab().apply {
                this.text = it
                tabLayoutProfile.addTab(this)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        return dialog
    }

    override fun navigateBack() {
        dismiss()
    }

    override fun showError(errorString: String) {
        Toast.makeText(context, errorString, Toast.LENGTH_SHORT).show()
    }


}