package com.example.quantitymeasurementapp


import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.text.TextWatcher

/**
 * Fragment1 is used to convert one quantity to other quantity
 * consists of 1 spinners and 1 edit text for input
 * consists of 1 spinner and 1 edit text for output
 */
class Fragment1 : Fragment(), AdapterView.OnItemSelectedListener {

    val units = arrayListOf<String?>("Temperature", "Distance", "Mass", "Volume")
    val temperatureValues = arrayListOf<String?>("Celsius", "Fahrenheit", "Kelvin")
    val volumeValues = arrayListOf<String?>("Liter", "Gallon", "Milli liter")
    val massValues = arrayListOf<String?>("KG", "Grams", "Pound")
    val distanceValues = arrayListOf<String?>("Meter", "killo meter", "centi meter")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment1, container, false)
        val spin = view.findViewById<Spinner>(R.id.spinnerFragment1)
        val secondSpin = view.findViewById<Spinner>(R.id.spinner3)
        val thirdSpin = view.findViewById<Spinner>(R.id.spinner4)
        spin.onItemSelectedListener = this
        secondSpin.onItemSelectedListener = this
        thirdSpin.onItemSelectedListener = this

        val array_adapter =
            ArrayAdapter<String>(view.context, android.R.layout.simple_spinner_item, units)

        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = array_adapter
        val input = view.findViewById<EditText>(R.id.editTextNumber)
        input.afterTextChanged {
            if (input.text != null)
                convertQt(view, input.text, spin)
        }
        return view
    }

    private fun convertQt(view: View?, text: Editable, spin: Spinner?) {
        if (text.isEmpty()) {
            noNumberToPrint()
            return
        }
        if (text.toString() != "") {
            when (spin?.selectedItemPosition) {
                0 -> convertTemp(view, text.toString())
                1 -> convertDistance(view, text.toString())
                2 -> convertMass(view, text.toString())
                3 -> convertVolume(view, text.toString())
            }
        }


    }

    /**
     * converts mass of one type to other
     * @param view and weight
     */
    private fun convertMass(view: View?, weight: String) {
        if (weight != "") {
            var tempspin: Int =
                view?.findViewById<Spinner>(R.id.spinner3)?.selectedItemPosition as Int
            val output = view?.findViewById<EditText>(R.id.editTextNumber2)
            when (tempspin) {
                0 -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItemPosition) {
                            0 -> {
                                output.setText(weight)
                            }
                            1 -> {
                                val res = weight.toDouble() * 1000
                                output.setText(res.toString())
                            }
                            2 -> {
                                val res = weight.toDouble() * 2.205
                                output.setText(res.toString())
                            }

                        }
                    }
                }
                1 -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItemPosition) {
                            1 -> {
                                output.setText(weight)
                            }
                            0 -> {
                                val res = weight.toDouble() / 1000
                                output.setText(res.toString())
                            }
                            2 -> {
                                val res = weight.toDouble() / 454
                                output.setText(res.toString())
                            }

                        }
                    }
                }
                2 -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItemPosition) {
                            2 -> {
                                output?.setText(weight)
                            }
                            0 -> {
                                val res = weight.toDouble() / 2.205
                                output.setText(res.toString())
                            }
                            1 -> {
                                val res = weight.toDouble() * 454
                                output.setText(res.toString())
                            }

                        }
                    }
                }

            }
        }

    }

    /**
     * converts volume of one type to other
     * @param view and volume
     */
    private fun convertVolume(view: View?, volume: String) {
        if (volume != "") {
            var tempspin: Int =
                view?.findViewById<Spinner>(R.id.spinner3)?.selectedItemPosition as Int
            val output = view?.findViewById<EditText>(R.id.editTextNumber2)
            when (tempspin) {
                0 -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItemPosition) {
                            0 -> {
                                output?.setText(volume)
                            }
                            1 -> {
                                val res = volume.toDouble() / 3.785
                                output.setText(res.toString())
                            }
                            2 -> {
                                val res = volume.toDouble() * 1000
                                output.setText(res.toString())
                            }

                        }
                    }
                }
                1 -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItemPosition) {
                            1 -> {
                                output?.setText(volume)
                            }
                            0 -> {
                                val res = volume.toDouble() * 3.785
                                output.setText(res.toString())
                            }
                            2 -> {
                                val res = volume.toDouble() * 3785
                                output.setText(res.toString())
                            }

                        }
                    }
                }
                2 -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItemPosition) {
                            2 -> {
                                output?.setText(volume)
                            }
                            0 -> {
                                val res = volume.toDouble() / 1000
                                output.setText(res.toString())
                            }
                            1 -> {
                                val res = volume.toDouble() / 3785
                                output.setText(res.toString())
                            }

                        }
                    }
                }
            }
        }

    }

    private fun noNumberToPrint() {
        val output = view?.findViewById<EditText>(R.id.editTextNumber2)
        output?.setText(" ")
    }
    /**
     * converts distance of one type to other
     * @param view and length
     */
    private fun convertDistance(view: View?, lenght: String) {
        if (lenght != "") {
            var tempspin: Int =
                view?.findViewById<Spinner>(R.id.spinner3)?.selectedItemPosition as Int
            val output = view?.findViewById<EditText>(R.id.editTextNumber2)
            when (tempspin) {
                0 -> {
                    //if(view != null) {
                    when (view?.findViewById<Spinner>(R.id.spinner4).selectedItemPosition) {
                        0 -> {
                            output?.setText(lenght)
                        }
                        1 -> {
                            val res = lenght.toDouble() / 1000
                            output.setText(res.toString())
                        }
                        2 -> {
                            val res = lenght.toDouble() * 100
                            output.setText(res.toString())
                        }
                    }
                    //}
                }
                1 -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItemPosition) {
                            1 -> {
                                output?.setText(lenght)
                            }
                            0 -> {
                                val res = lenght.toDouble() * 1000
                                output.setText(res.toString())
                            }
                            2 -> {
                                val res = lenght.toDouble() * 100000
                                output.setText(res.toString())
                            }
                        }

                    }

                }
                2 -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItemPosition) {
                            2 -> {
                                output?.setText(lenght)
                            }
                            0 -> {
                                val res = lenght.toDouble() / 100
                                output.setText(res.toString())
                            }
                            1 -> {
                                val res = lenght.toDouble() / 100000
                                output.setText(res.toString())
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * converts temperature of one type to other
     * @param view and temperature
     */
    private fun convertTemp(view: View?, temp: String) {
        if (temp != "") {
            var tempspin: String =
                view?.findViewById<Spinner>(R.id.spinner3)?.selectedItem as String
            val output = view?.findViewById<EditText>(R.id.editTextNumber2)
            when (tempspin) {
                "Celsius" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Celsius" -> {
                                if (output != null) {
                                    output.setText(temp)
                                }
                            }
                            "Fahrenheit" -> {
                                val res = temp.toInt() * 1.8 + 32
                                output.setText(res.toString())
                            }
                            "Kelvin" -> {
                                val res = temp.toInt() + 273.15
                                output.setText(res.toString())
                            }
                        }
                    }
                }
                "Fahrenheit" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Fahrenheit" -> {
                                if (output != null) {
                                    output.setText(temp)
                                }
                            }
                            "Celsius" -> {
                                val res = (temp.toInt() - 32) * 5 / 9
                                output.setText(res.toString())
                            }
                            "Kelvin" -> {
                                val res = (temp.toInt() - 32) * 5 / 9 + 273.15
                                println(res)
                                output.setText(res.toString())
                            }
                        }
                    }
                }
                "Kelvin" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Kelvin" -> {
                                if (output != null) {
                                    output.setText(temp)
                                }
                            }
                            "Celsius" -> {
                                val res = temp.toInt() - 273.15
                                output.setText(res.toString())
                            }
                            "Fahrenheit" -> {
                                val res = (temp.toInt() - 273.15) * 9 / 5 + 32
                                output.setText(res.toString())
                            }
                        }
                    }
                }
            }
        }

    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
        var tempSpin = view?.findViewById<Spinner>(R.id.spinnerFragment1)
        var index = tempSpin?.selectedItemPosition
        var inputView = view?.findViewById<EditText>(R.id.editTextNumber)
        val input = inputView?.text.toString()
        when (p0?.id) {
            R.id.spinnerFragment1 -> {
                when (pos) {
                    0 -> {
                        loadTempSpin(R.id.spinner3, temperatureValues)
                        loadTempSpin(R.id.spinner4, temperatureValues)
                    }
                    1 -> {
                        loadTempSpin(R.id.spinner3, distanceValues)
                        loadTempSpin(R.id.spinner4, distanceValues)
                    }
                    2 -> {
                        loadTempSpin(R.id.spinner3, massValues)
                        loadTempSpin(R.id.spinner4, massValues)
                    }
                    3 -> {
                        loadTempSpin(R.id.spinner3, volumeValues)
                        loadTempSpin(R.id.spinner4, volumeValues)
                    }

                }
            }

            R.id.spinner4 -> {

                if (index == 0) {
                    convertTemp(view, input)
                } else if (index == 1) {
                    convertDistance(view, input)
                } else if (index == 2) {
                    convertMass(view, input)
                } else if (index == 3) {
                    convertVolume(view, input)
                }

            }
            R.id.spinner3 -> {
                if (index == 0) {
                    convertTemp(view, input)

                } else if (index == 1) {
                    convertDistance(view, input)
                } else if (index == 2) {
                    convertMass(view, input)
                } else if (index == 3) {
                    convertVolume(view, input)
                }


            }


        }
    }

    private fun loadTempSpin(elementeId: Int, listOfValues: ArrayList<String?>) {
        var tempSpin = view?.findViewById<Spinner>(elementeId)
        val temp_adapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_item,
            listOfValues
        )

        temp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tempSpin?.adapter = temp_adapter

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}
