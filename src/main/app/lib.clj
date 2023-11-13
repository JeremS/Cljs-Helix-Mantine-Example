(ns app.lib
  (:require
    [helix.core :as hc]
    [com.rpl.specter :as s]))


(defmacro defnc [type params & body]
  (let [[docstring params body] (if (string? params)
                                  [params (first body) (rest body)]
                                  [nil params body])
        opts? (map? (first body)) ;; whether an opts map was passed in
        opts (if opts?
               (first body)
               {})
        body (if opts?
               (rest body)
               body)
        ;; feature flags to enable by default
        default-opts {:helix/features {:fast-refresh true}}]
    `(helix.core/defnc ~type ~@(when docstring [docstring]) ~params
       ;; we use `merge` here to allow indidivual consumers to override feature
       ;; flags in special cases
       ~(merge default-opts opts)
       ~@body)))


(defmacro defmacro-alias [sym src-sym]
  (let [src (symbol (resolve src-sym))]
    `(defmacro ~sym [& args#]
       (list* '~src args#))))

(defmacro select [structure apath]
  `(com.rpl.specter/select ~apath ~structure))

(defmacro select-one [structure apath]
  `(com.rpl.specter/select-one ~apath ~structure))


