package com.example.quantitymeasurementapp




import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.quantitymeasurementapp.databinding.Fragment2Binding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Fragment2 : Fragment(),AdapterView.OnItemSelectedListener {

    val units= arrayListOf<String?>("Temperature","Distance","Mass","Volume")
    val temperatureValues= arrayListOf<String?>("Celcius","Farehnet","Kelvin")
    val volumeValues= arrayListOf<String?>("Liter","Gallon","Milli liter")
    val massValues= arrayListOf<String?>("KG","Ton","quintal")
    val distanceValues= arrayListOf<String?>("Meter","kilo meter","centi meter")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view=inflater.inflate(R.layout.fragment2, container, false)
        var spin=view.findViewById<Spinner>(R.id.spinnerFragment1)
        spin.onItemSelectedListener = this
        val array_adapter = ArrayAdapter<String>(view.context, android.R.layout.simple_spinner_item, units)

        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter=array_adapter
        return view
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
        when(p0?.id){
            R.id.spinnerFragment1 ->{
                when(pos){
                    0->{loadTempSpin(R.id.spinner3,temperatureValues)
                        loadTempSpin(R.id.spinner4,temperatureValues)
                        loadTempSpin(R.id.spinnerOutput,temperatureValues)
                    }
                    1->{
                        loadDistanceSpin(R.id.spinner3,distanceValues)
                        loadDistanceSpin(R.id.spinner4,distanceValues)
                        loadDistanceSpin(R.id.spinnerOutput,distanceValues)
                    }
                    2 -> {
                        loadMassSpin(R.id.spinner3,massValues)
                        loadMassSpin(R.id.spinner4,massValues)
                        loadMassSpin(R.id.spinnerOutput,massValues)
                    }

                    3 -> {
                        loadVolumeSpin(R.id.spinner3,volumeValues)
                        loadVolumeSpin(R.id.spinner4,volumeValues)
                        loadVolumeSpin(R.id.spinnerOutput,volumeValues)
                    }

                }
            }
        }

    }

    private fun loadVolumeSpin(elementId: Int, volumeValues: ArrayList<String?>) {
        var tempSpin=view?.findViewById<Spinner>(elementId)
        val temp_adapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, volumeValues)

        temp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tempSpin?.adapter=temp_adapter
    }

    private fun loadMassSpin(elementId: Int, massValues: ArrayList<String?>) {
        var tempSpin=view?.findViewById<Spinner>(elementId)
        val temp_adapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, massValues)

        temp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tempSpin?.adapter=temp_adapter
    }

    private fun loadDistanceSpin(elementId: Int, distanceValues: ArrayList<String?>) {
        var tempSpin=view?.findViewById<Spinner>(elementId)
        val temp_adapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, distanceValues)

        temp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tempSpin?.adapter=temp_adapter
    }

    private fun loadTempSpin(elementeId:Int,listOfValues:ArrayList<String?>) {
        var tempSpin=view?.findViewById<Spinner>(elementeId)
        val temp_adapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, listOfValues)

        temp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tempSpin?.adapter=temp_adapter
        var input1 = tempSpin?.selectedItem.toString()
        Toast.makeText(context,"$input1",Toast.LENGTH_SHORT).show()

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}
