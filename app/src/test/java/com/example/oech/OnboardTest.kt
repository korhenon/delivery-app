package com.example.oech

import com.example.oech.data.utils.OnboardPages
import com.example.oech.ui.screen.onboard.OnboardViewModel
import org.junit.Assert
import org.junit.Test

class OnboardTest {
    @Test
    fun correct_pop() {
        val vm = OnboardViewModel()
        vm.next()
        Assert.assertEquals(vm.page, OnboardPages[1])
    }

    @Test
    fun correct_queue_size() {
        val vm = OnboardViewModel()
        vm.next()
        Assert.assertEquals(vm.queueSize, 2)
    }

    @Test
    fun correct_button_text_full_queue() {
        val vm = OnboardViewModel()

        vm.next()

        Assert.assertEquals(vm.buttonText, "Next")
    }

    @Test
    fun correct_button_text_empty_queue() {
        val vm = OnboardViewModel()
        vm.next()
        vm.next()
        Assert.assertEquals(vm.buttonText, "Sign Up")
    }

    @Test
    fun correct_nav_destination_full_queue() {
        val vm = OnboardViewModel()
        vm.next()
        Assert.assertEquals(vm.navDestination, "")
    }

    @Test
    fun correct_nav_destination_empty_queue() {
        val vm = OnboardViewModel()
        vm.next()
        vm.next()
        Assert.assertEquals(vm.navDestination, "Holder")
    }
}