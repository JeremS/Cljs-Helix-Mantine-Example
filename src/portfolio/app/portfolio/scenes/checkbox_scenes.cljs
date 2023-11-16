(ns app.portfolio.scenes.checkbox-scenes
  (:require
    [helix.core :as hc :refer [$]]
    [portfolio.react-18 :refer-macros [defscene]]
    ["@mantine/core" :as mt]))


(defscene mantine-checkbox
  ($ mt/MantineProvider {:defaultColorScheme "light"}
     ($ mt/Checkbox  {:defaultChecked true :label "I disagree"})))

