/*
 * Created By: jinsu4755
 * on 2020.12.11
 */

package sopt.onsopt.semina.presentation.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sopt.onsopt.semina.R

class InfoFirstFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_first,container,false)
    }
}