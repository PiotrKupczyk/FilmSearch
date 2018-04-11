package fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.piotrkupczyk.filmsearch.R
import consts.Consts

class MovieDescriptionFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val description = arguments.getString(Consts.DESCRIPTION)
        val view = inflater?.inflate(R.layout.move_description_fragment, container!!, false)
        val textView = view?.findViewById<TextView>(R.id.movieDescription)
        textView?.text = description
        return view
    }
}