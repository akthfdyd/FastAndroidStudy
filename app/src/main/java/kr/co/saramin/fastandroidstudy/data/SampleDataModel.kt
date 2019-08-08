package kr.co.saramin.fastandroidstudy.data

class SampleDataModel {
    var intVariable: Int = 0
        get() = field
        set(value) {
            field = value
        }

    var stringVariable: String = ""
        get() = field
        set(value) {
            field = value
        }
}

class SampleDataModelByProperty(
    var intVariable: Int,
    var stringVariable: String
)

data class SampleDataModelByDataClass(
    var intVariable: Int,
    var stringVariable: String
)

data class SampleDataModelByDataClassNullable(
    var intVariable: Int?,
    var stringVariable: String?
)

data class SampleDataModelByDataClassNullInit(
    var intVariable: Int? = null,
    var stringVariable: String? = null
)

val sampleDataModel = SampleDataModel()
val sampleDataModelByProperty = SampleDataModelByProperty(intVariable = 1, stringVariable = "")
val sampleDataModelByDataClass = SampleDataModelByDataClass(intVariable = 2, stringVariable = "_")
val sampleDataModelByDataClassNullable = SampleDataModelByDataClassNullable(null, null)
val sampleDataModelByDataClassNullInit = SampleDataModelByDataClassNullInit()