package uk.kulikov.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressResponse(
    @SerialName("id") var id: String,
    @SerialName("postcode") var postcode: String? = null,
    @SerialName("country") var country: String? = null,
    @SerialName("city") var city: String? = null,
    @SerialName("street_line_1") var streetLine1: String? = null,
    @SerialName("street_line_2") var streetLine2: String? = null,
    @SerialName("coordinates") var coordinates: ArrayList<Double> = arrayListOf(),
    @SerialName("meters") var meters: ArrayList<Meters> = arrayListOf(),
    @SerialName("color") var color: String? = null,
    @SerialName("address_name") var addressName: String? = null
)

@Serializable
data class Meters(
    @SerialName("mpan_core") var mpanCore: Long? = null,
    @SerialName("status") var status: String? = null,
    @SerialName("is_smart") var isSmart: Boolean? = null,
    @SerialName("can_be_upgraded") var canBeUpgraded: Boolean? = null,
    @SerialName("serial_number") var serialNumber: String? = null,
    @SerialName("switching") var switching: String? = null
)