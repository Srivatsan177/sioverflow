import { BaseResponse } from "../BaseResponse";
import { Question } from "./Question";

export type QuestionsResponse = BaseResponse & {
  data: Question[];
};