import {defaultResponseHandler, getConfig} from "@/api/fetch-utils";

import type {SubTodo} from "@/types/SubTodo.ts";

export function getAllSubTodos(): Promise<SubTodo[]> {
    return fetch("/api/backend-service/todo/sub", getConfig())
        .then((response) => {
            defaultResponseHandler(response);
            return response.json();
        })
        .catch((err) => {
            defaultResponseHandler(err);
        });
}