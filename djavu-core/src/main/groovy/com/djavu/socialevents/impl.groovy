package com.djavu.socialevents

import javax.inject.*
import javax.ws.rs.core.*
import javax.servlet.http.*
import javax.enterprise.inject.*
import javax.enterprise.context.*

@Named
class SocialEventResourcesImpl implements SocialEventResources {

    @Inject
    SocialEventRepository repo

    SocialEvent[] get() {
        repo.findAll()
    }
}
