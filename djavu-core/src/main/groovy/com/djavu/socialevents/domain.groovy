package com.djavu.socialevents

import static javax.persistence.TemporalType.TIMESTAMP
import static javax.xml.bind.annotation.XmlAccessType.NONE

import javax.persistence.*
import javax.xml.bind.annotation.*
import javax.validation.constraints.*

import groovy.transform.*

@Entity
@XmlRootElement
@XmlAccessorType(NONE)
@ToString
@EqualsAndHashCode
class SocialEvent {

	@Id
	@XmlElement
	@GeneratedValue
	Long id

	@NotNull
	@XmlElement
	String name
}
