#
# contest_sponsor.rb
# 
# Generated by JSON Model Generator v0.0.3 on Sun Mar 15 08:44:00 MDT 2015.
# https://github.com/intere/generator-json-models
# 
# The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
#

class ContestSponsor < JsonModel
	def address1
		json.try(:[], :address1)
	end

	def address2
		json.try(:[], :address2)
	end

	def category
		json.try(:[], :category)
	end

	def city
		json.try(:[], :city)
	end

	def contact_email
		json.try(:[], :contactEmail)
	end

	def contact_name
		json.try(:[], :contactName)
	end

	def contact_title
		json.try(:[], :contactTitle)
	end

	def id
		json.try(:[], :id)
	end

	def logo
		json.try(:[], :logo)
	end

	def name
		json.try(:[], :name)
	end

	def phone_number
		json.try(:[], :phoneNumber)
	end

	def site_url
		json.try(:[], :siteUrl)
	end

	def state
		json.try(:[], :state)
	end

	def zip
		json.try(:[], :zip)
	end


end		# End of ContestSponsor

