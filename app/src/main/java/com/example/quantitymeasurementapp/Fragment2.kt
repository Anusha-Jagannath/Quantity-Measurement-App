package com.example.quantitymeasurementapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment


/**
 *
 * Fragment2 is used to add one quantity to other quantity
 * consists of 2 spinners and 2 edit text for input
 * performs addition of 2 quantities
 * consists of 1 spinner and 1 edit text for output
 */

class Fragment2 : Fragment(), AdapterView.OnItemSelectedListener {

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

        val view = inflater.inflate(R.layout.fragment2, container, false)
        val spin = view.findViewById<Spinner>(R.id.spinnerFragment1)
        val secondSpin = view.findViewById<Spinner>(R.id.spinner3)
        val thirdSpin = view.findViewById<Spinner>(R.id.spinner4)
        val fourthSpin = view.findViewById<Spinner>(R.id.spinnerOutput)

        spin.onItemSelectedListener = this
        secondSpin.onItemSelectedListener = this
        thirdSpin.onItemSelectedListener = this
        fourthSpin.onItemSelectedListener = this

        val array_adapter =
            ArrayAdapter<String>(view.context, android.R.layout.simple_spinner_item, units)

        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = array_adapter
        val input = view.findViewById<EditText>(R.id.editTextNumber)
        val input2 = view.findViewById<EditText>(R.id.editTextNumber2)
        input.afterTextChanged1 {
            input2.afterTextChanged1 {
                if (input.text != null && input2.text != null)
                    convertQt(view, input.text, input2.text, spin)
            }
        }
        return view
    }

    private fun convertQt(view: View?, text: Editable, text2: Editable, spin: Spinner?) {
        if (text.isEmpty() && text2.isEmpty()) {
            noNumberToPrint()
            return
        }
        if (text.toString() != "" && text2.toString() != "") {

            when (spin?.selectedItemPosition) {
                0 -> convertTemp(view, text.toString(), text2.toString())
                1 -> convertDistance(view, text.toString(), text2.toString())
                2 -> convertMass(view, text.toString(), text2.toString())
                3 -> convertVolume(view, text.toString(), text2.toString())
            }
        }


    }

    /**
     * adds to mass quantity
     * @param view temp,temp2
     * renders result
     */
    private fun convertMass(view: View?, temp: String, temp2: String) {
        if (temp != "" && temp2 != " ") {
            var tempspin: String =
                view?.findViewById<Spinner>(R.id.spinner3)?.selectedItem as String
            var tempspin1: String =
                view?.findViewById<Spinner>(R.id.spinner4)?.selectedItem as String
            var tempResult: String =
                view?.findViewById<Spinner>(R.id.spinnerOutput)?.selectedItem as String
            val output = view?.findViewById<EditText>(R.id.editTextResult)
            when (tempspin) {
                "KG" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "KG" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "KG" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()
                                            val res = inputValue + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Grams" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = kgToGram(inputValue)
                                            var second = kgToGram(inputValue2)
                                            var res = first + second
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Pound" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                kgToPounds(inputValue) + kgToPounds(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "Grams" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "KG" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = inputValue + gramToKg(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Grams" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var first = kgToGram(inputValue)
                                            var res = first + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Pound" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                kgToPounds(inputValue) + gramToPounds(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "Pound" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "KG" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = inputValue + poundsToKg(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Grams" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = kgToGram(inputValue)
                                            var res = first + poundsToGrams(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Pound" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                kgToPounds(inputValue) + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }


                //second layer
                "Grams" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "KG" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "KG" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            val res = gramToKg(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Grams" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var second = kgToGram(inputValue2)
                                            var res = inputValue + second
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Pound" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var result =
                                                gramToPounds(inputValue) + kgToPounds(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "Grams" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "KG" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = gramToKg(inputValue) + gramToKg(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Grams" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res = inputValue + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Pound" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result = gramToPounds(inputValue) + gramToPounds(
                                                inputValue2
                                            )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "Pound" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "KG" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = gramToKg(inputValue) + poundsToKg(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Grams" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res = inputValue + poundsToGrams(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Pound" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                gramToPounds(inputValue) + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }

                //second layer end


                //third layer starts


                "Pound" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "KG" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "KG" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            val res = poundsToKg(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Grams" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res =
                                                poundsToGrams(inputValue) + kgToGram(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Pound" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                inputValue + kgToPounds(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "Grams" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "KG" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = poundsToKg(inputValue) + gramToKg(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Grams" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var res = poundsToGrams(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Pound" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result = inputValue + gramToPounds(
                                                inputValue2
                                            )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "Pound" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "KG" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = poundsToKg(inputValue) + poundsToKg(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Grams" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res = poundsToGrams(inputValue) + poundsToGrams(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Pound" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                inputValue + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }


                //third layer ends


            }

        }
    }



    /**
     * adds to volume quantity
     * @param view temp,temp2
     * renders result
     */
    private fun convertVolume(view: View?, temp: String, temp2: String) {
        if (temp != "" && temp2 != null) {
            var tempspin: String =
                view?.findViewById<Spinner>(R.id.spinner3)?.selectedItem as String
            var tempspin1: String =
                view?.findViewById<Spinner>(R.id.spinner4)?.selectedItem as String
            var tempResult: String =
                view?.findViewById<Spinner>(R.id.spinnerOutput)?.selectedItem as String
            val output = view?.findViewById<EditText>(R.id.editTextResult)
            when (tempspin) {
                "Liter" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Liter" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Liter" -> {


                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            val res = inputValue + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Gallon" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = literToGallon(inputValue)
                                            var second = literToGallon(inputValue2)
                                            var res = first + second
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Milli liter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                literToMilliLiter(inputValue) + literToMilliLiter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "Gallon" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = inputValue + gallonToLiter(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Gallon" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = literToGallon(inputValue)
                                            var res = first + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Milli Liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                literToMilliLiter(inputValue) + gallonToMilliter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "Milli liter" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = inputValue + milliLiterToLiter(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Gallon" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = literToGallon(inputValue)
                                            var res = first + milliLiterToGallon(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Milli liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                literToMilliLiter(inputValue) + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }


                //second layer
                "Gallon" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Liter" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            val res = gallonToLiter(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Gallon" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var second = literToGallon(inputValue2)
                                            var res = inputValue + second
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Milli liter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                gallonToMilliter(inputValue) + literToMilliLiter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "Gallon" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = gallonToLiter(inputValue) + gallonToLiter(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Gallon" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var res = inputValue + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Milli liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                gallonToMilliter(inputValue) + gallonToMilliter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "Milli liter" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = gallonToLiter(inputValue) + milliLiterToLiter(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Gallon" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res = inputValue + milliLiterToGallon(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Milli liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                gallonToMilliter(inputValue) + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }

                //second layer end


                //third layer starts


                "Milli liter" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Liter" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            val res = milliLiterToLiter(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Gallon" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var res =
                                                milliLiterToGallon(inputValue) + literToGallon(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Milli liter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                inputValue + literToMilliLiter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "Gallon" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = milliLiterToLiter(inputValue) + gallonToLiter(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Gallon" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()



                                            var res = milliLiterToGallon(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Milli liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var result = inputValue + gallonToMilliter(
                                                inputValue2
                                            )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "Milli liter" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res =
                                                milliLiterToLiter(inputValue) + milliLiterToLiter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Gallon" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res =
                                                milliLiterToGallon(inputValue) + milliLiterToGallon(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Milli liter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var result =
                                                inputValue + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }


                //third layer ends


            }

        }
    }



    private fun noNumberToPrint() {
        val output = view?.findViewById<EditText>(R.id.editTextNumber2)
        output?.setText(" ")
    }

    /**
     * adds to distance quantity
     * @param view temp,temp2
     * renders result
     */
    private fun convertDistance(view: View?, temp: String, temp2: String) {
        if (temp != "" && temp2 != null) {
            var tempspin: String =
                view?.findViewById<Spinner>(R.id.spinner3)?.selectedItem as String
            var tempspin1: String =
                view?.findViewById<Spinner>(R.id.spinner4)?.selectedItem as String
            var tempResult: String =
                view?.findViewById<Spinner>(R.id.spinnerOutput)?.selectedItem as String
            val output = view?.findViewById<EditText>(R.id.editTextResult)
            when (tempspin) {
                "Meter" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Meter" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Meter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = inputValue + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "killo meter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = meterToKiloMeter(inputValue)
                                            var second = meterToKiloMeter(inputValue2)
                                            var res = first + second
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "centi meter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                meterToCentiMeter(inputValue) + meterToCentiMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "killo meter" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = inputValue + kiloMeterToMeter(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "killo meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = meterToKiloMeter(inputValue)
                                            var res = first + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "centi meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                meterToCentiMeter(inputValue) + kiloMeterToCentiMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "centi meter" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = inputValue + centiMeterToMeter(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "killo meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = meterToKiloMeter(inputValue)
                                            var res = first + centiMeterToKiloMeter(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "centi meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                meterToCentiMeter(inputValue) + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }


                //second layer
                "killo meter" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "meter" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            val res = kiloMeterToMeter(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "killo meter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var second = meterToKiloMeter(inputValue2)
                                            var res = inputValue + second
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "centi meter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                kiloMeterToCentiMeter(inputValue) + meterToCentiMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "killo meter" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res =
                                                kiloMeterToMeter(inputValue) + kiloMeterToMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "killo meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res = inputValue + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "centi meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var result =
                                                kiloMeterToCentiMeter(inputValue) + kiloMeterToCentiMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "centi meter" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res =
                                                kiloMeterToMeter(inputValue) + centiMeterToMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "killo meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res =
                                                inputValue + centiMeterToKiloMeter(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "centi meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                kiloMeterToCentiMeter(inputValue) + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }

                //second layer end


                //third layer starts


                "centi meter" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Meter" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            val res = centiMeterToMeter(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "killo meter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res =
                                                centiMeterToKiloMeter(inputValue) + meterToKiloMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "centi meter" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                inputValue + meterToCentiMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "killo meter" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res =
                                                centiMeterToMeter(inputValue) + kiloMeterToMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "killo meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var res =
                                                centiMeterToKiloMeter(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "centi meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result = inputValue + kiloMeterToCentiMeter(
                                                inputValue2
                                            )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "centi meter" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res =
                                                centiMeterToMeter(inputValue) + centiMeterToMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "killo meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var res =
                                                centiMeterToKiloMeter(inputValue) + centiMeterToKiloMeter(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "centi meter" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var result =
                                                inputValue + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }


                //third layer ends


            }

        }
    }



    /**
     * adds to temperature quantity
     * @param view temp,temp2
     * renders result
     */
    private fun convertTemp(view: View?, temp: String, temp2: String) {
        if (temp != "" && temp2 != null) {
            var tempspin: String =
                view?.findViewById<Spinner>(R.id.spinner3)?.selectedItem as String
            var tempspin1: String =
                view?.findViewById<Spinner>(R.id.spinner4)?.selectedItem as String
            var tempResult: String =
                view?.findViewById<Spinner>(R.id.spinnerOutput)?.selectedItem as String
            val output = view?.findViewById<EditText>(R.id.editTextResult)
            when (tempspin) {
                "Celsius" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Celsius" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Celsius" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()
                                            val res = inputValue + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Fahrenheit" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = celciusToFahrenheit(inputValue)
                                            var second = celciusToFahrenheit(inputValue2)
                                            var res = first + second
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Kelvin" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                celciusToKelvin(inputValue) + celciusToKelvin(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "Fahrenheit" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Celsius" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = inputValue + farenTocelsius(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Fahrenheit" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = celciusToFahrenheit(inputValue)
                                            var res = first + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Kelvin" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                celciusToKelvin(inputValue) + farenToKelvin(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "Kelvin" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Celsius" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = inputValue + kelvinToCelsius(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Fahrenheit" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var first = celciusToFahrenheit(inputValue)
                                            var res = first + kelvinToFeren(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Kelvin" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                celciusToKelvin(inputValue) + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }


                //second layer
                "Fahrenheit" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Celsius" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Celsius" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            val res = farenTocelsius(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Fahrenheit" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var second = celciusToFahrenheit(inputValue2)
                                            var res = inputValue + second
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Kelvin" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                farenToKelvin(inputValue) + celciusToKelvin(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "Fahrenheit" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Celsius" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = farenTocelsius(inputValue) + farenTocelsius(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Fahrenheit" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res = inputValue + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Kelvin" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result = farenToKelvin(inputValue) + farenToKelvin(
                                                inputValue2
                                            )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "Kelvin" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Celsius" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = farenTocelsius(inputValue) + kelvinToCelsius(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Fahrenheit" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res = inputValue + kelvinToFeren(inputValue2)
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Kelvin" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                farenToKelvin(inputValue) + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }

                //second layer end


                //third layer starts


                "Kelvin" -> {
                    if (view != null) {
                        when (view.findViewById<Spinner>(R.id.spinner4).selectedItem as String) {
                            "Celsius" -> {
                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Celsius" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            val res = kelvinToCelsius(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Fahrenheit" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res =
                                                kelvinToFeren(inputValue) + celciusToFahrenheit(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Kelvin" -> {

                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var result =
                                                inputValue + celciusToKelvin(
                                                    inputValue2
                                                )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }
                            }

                            "Fahrenheit" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Celsius" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = kelvinToCelsius(inputValue) + farenTocelsius(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Fahrenheit" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()

                                            var res = kelvinToFeren(inputValue) + inputValue2
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Kelvin" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var result = inputValue + farenToKelvin(
                                                inputValue2
                                            )
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                            "Kelvin" -> {

                                if (view != null) {
                                    when (view.findViewById<Spinner>(R.id.spinnerOutput).selectedItem as String) {

                                        "Celsius" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            val res = kelvinToCelsius(inputValue) + kelvinToCelsius(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Fahrenheit" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var res = kelvinToFeren(inputValue) + kelvinToFeren(
                                                inputValue2
                                            )
                                            output.setText("Result= ${res.toString()}")
                                        }

                                        "Kelvin" -> {
                                            var inputView =
                                                view?.findViewById<EditText>(R.id.editTextNumber)
                                            var inputValue = inputView?.text.toString().toDouble()

                                            var inputView2 =
                                                view?.findViewById<EditText>(R.id.editTextNumber2)
                                            var inputValue2 = inputView2?.text.toString().toDouble()


                                            var result =
                                                inputValue + inputValue2
                                            output.setText("Result= ${result.toString()}")
                                        }

                                    }

                                }

                            }


                        }
                    }
                }


                //third layer ends


            }

        }
    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
        var tempSpin = view?.findViewById<Spinner>(R.id.spinnerFragment1)
        var index = tempSpin?.selectedItemPosition
        var inputView = view?.findViewById<EditText>(R.id.editTextNumber)
        val input = inputView?.text.toString()


        var inputView2 = view?.findViewById<EditText>(R.id.editTextNumber2)
        val input2 = inputView2?.text.toString()

        when (p0?.id) {
            R.id.spinnerFragment1 -> {
                when (pos) {
                    0 -> {
                        loadTempSpin(R.id.spinner3, temperatureValues)
                        loadTempSpin(R.id.spinner4, temperatureValues)
                        loadTempSpin(R.id.spinnerOutput, temperatureValues)
                    }
                    1 -> {
                        loadTempSpin(R.id.spinner3, distanceValues)
                        loadTempSpin(R.id.spinner4, distanceValues)
                        loadTempSpin(R.id.spinnerOutput, distanceValues)
                    }
                    2 -> {
                        loadTempSpin(R.id.spinner3, massValues)
                        loadTempSpin(R.id.spinner4, massValues)
                        loadTempSpin(R.id.spinnerOutput, massValues)
                    }
                    3 -> {
                        loadTempSpin(R.id.spinner3, volumeValues)
                        loadTempSpin(R.id.spinner4, volumeValues)
                        loadTempSpin(R.id.spinnerOutput, volumeValues)
                    }

                }
            }

            R.id.spinner4 -> {

                if (index == 0) {
                    convertTemp(view, input, input2)
                } else if (index == 1) {
                    convertDistance(view, input, input2)
                } else if (index == 2) {
                    convertMass(view, input, input2)
                } else if (index == 3) {
                    convertVolume(view, input, input2)
                }

            }
            R.id.spinner3 -> {
                if (index == 0) {
                    convertTemp(view, input, input2)

                } else if (index == 1) {
                    convertDistance(view, input, input2)
                } else if (index == 2) {
                    convertMass(view, input, input2)
                } else if (index == 3) {
                    convertVolume(view, input, input2)
                }


            }


            R.id.spinnerOutput -> {

                if (index == 0) {
                    convertTemp(view, input, input2)

                } else if (index == 1) {
                    convertDistance(view, input, input2)
                } else if (index == 2) {
                    convertMass(view, input, input2)
                } else if (index == 3) {
                    convertVolume(view, input, input2)
                }


            }


        }
    }


    private fun kelvinToFeren(input: Double): Double {
        val output = (input - 273.15) * 9 / 5 + 32
        return output
    }

    private fun kelvinToCelsius(inputValue: Double): Double {
        val output = inputValue - 273.15
        return output
    }

    private fun farenToKelvin(inputValue: Double): Double {
        val output = inputValue - 32 * 5 / 9 + 273.15
        return output
    }

    private fun farenTocelsius(inputValue: Double): Double {
        val output = (inputValue - 32) * 5 / 9
        return output
    }

    private fun celciusToFahrenheit(inputValue: Double): Double {
        var output = inputValue * 1.8 + 32
        return output
    }


    private fun celciusToKelvin(input: Double): Double {
        var output = input + 273.15
        return output
    }

    private fun meterToKiloMeter(inputValue: Double): Double {
        var output = inputValue / 1000
        return output
    }


    private fun meterToCentiMeter(inputValue: Double): Double {
        var output = inputValue * 100
        return output
    }


    private fun kiloMeterToMeter(inputValue: Double): Double {
        var output = inputValue * 1000
        return output
    }

    private fun kiloMeterToCentiMeter(inputValue: Double): Double {
        var output = inputValue * 100000
        return output
    }


    private fun centiMeterToMeter(inputValue: Double): Double {
        var output = inputValue / 100
        return output
    }

    private fun centiMeterToKiloMeter(inputValue: Double): Double {
        var output = inputValue / 100000
        return output
    }

    private fun literToGallon(inputValue: Double): Double {
        var output = inputValue / 3.785
        return output
    }

    private fun literToMilliLiter(inputValue: Double): Double {
        var output = inputValue * 1000
        return output
    }

    private fun gallonToLiter(inputValue: Double): Double {
        var output = inputValue * 3.785
        return output
    }

    private fun gallonToMilliter(inputValue: Double): Double {
        var output = inputValue / 3.785
        return output
    }

    private fun milliLiterToLiter(inputValue: Double): Double {
        var output = inputValue / 1000
        return output
    }

    private fun milliLiterToGallon(inputValue: Double): Double {
        var output = inputValue / 3785
        return output
    }

    private fun kgToGram(inputValue: Double): Double {
        var output = inputValue * 1000
        return output
    }

    private fun kgToPounds(inputValue: Double): Double {
        var output = inputValue * 2.205
        return output
    }

    private fun gramToKg(inputValue: Double): Double {
        var output = inputValue / 1000
        return output
    }

    private fun gramToPounds(inputValue: Double): Double {
        var output = inputValue / 454
        return output
    }

    private fun poundsToKg(inputValue: Double): Double {
        var output = inputValue / 2.205
        return output
    }

    private fun poundsToGrams(inputValue: Double): Double {
        var output = inputValue * 454
        return output
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

fun EditText.afterTextChanged1(afterTextChanged: (String) -> Unit) {
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

