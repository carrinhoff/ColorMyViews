package pt.zara.android.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import pt.zara.android.data.FirebaseServiceObject
import pt.zara.android.data.model.Item

class ItemViewModel : ViewModel() {

     val item = MutableLiveData<Item>()


    fun getItem(referenceId: String){
        viewModelScope.launch {
            item.value = FirebaseServiceObject.getItem(referenceId)
        }
    }
}