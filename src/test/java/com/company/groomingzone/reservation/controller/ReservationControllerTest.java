package com.company.groomingzone.reservation.controller;

import com.company.groomingzone.AbstractRestDocsController;
import com.company.groomingzone.reservation.controller.request.ReservationCreateRequest;
import com.company.groomingzone.reservation.domain.ReservationTarget;
import com.company.groomingzone.reservation.service.ReservationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservationController.class)
class ReservationControllerTest extends AbstractRestDocsController {

    @MockBean
    private ReservationService reservationService;

    @Test
    @DisplayName("예약 생성")
    void reserve() throws Exception {
        // given
        Long customerId = 1L;
        ReservationCreateRequest request = new ReservationCreateRequest(1L, 1L, 1L);
        Long createdId = 1L;
        given(reservationService.reserve(anyLong(), any(ReservationTarget.class))).willReturn(createdId);

        // when & then
        mockMvc.perform(post("/v1/reservations")
                        .param("customerId", String.valueOf(customerId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(request)))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("reservation-create",
                            requestFields(
                                    fieldWithPath("barberShopId").description("바버샵 ID"),
                                    fieldWithPath("scheduleId").description("스케줄 ID"),
                                    fieldWithPath("styleId").description("시술 ID")
                            ),
                            responseFields(
                                    fieldWithPath("status").description("응답 상태"),
                                    fieldWithPath("message").description("응답 메시지").optional(),
                                    fieldWithPath("data.id").description("생성된 예약 ID"),
                                    fieldWithPath("timeStamp").description("응답 시간")
                            )
                        )
                );
    }
}
