(ns triangle_minimum_path)

(defn min-path
  ([rows] (min-path rows 0))
  ([rows index]
    (let [weight ((first rows) index)
          rest-weight (cond (= (count rows) 1) 0
                            :else (min (min-path (rest rows) (inc index))
                                       (min-path (rest rows) index)))]
      (+ weight rest-weight)
    )
  )
)